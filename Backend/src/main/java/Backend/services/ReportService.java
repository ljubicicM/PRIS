package Backend.services;

import Backend.dto.ArtPieceDTO;
import Backend.dto.ReportDTO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    public JasperPrint createReport(ReportDTO dto) throws JRException, IOException {
        if (dto == null) {
            return null;
        }
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dto.getArtPieces());
        InputStream inputStream = this.getClass().getResourceAsStream("/jasperreports/PrisReport.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
        Map<String, Object> params = new HashMap<>();
        params.put("routeString", dto.getRouteString());
        params.put("hours", dto.getHours());
        params.put("minutes", dto.getMinutes());
        params.put("routeGenerality", dto.getRouteGenerality());
        params.put("context", getContext(dto));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
        return jasperPrint;
    }

    public String getContext(ReportDTO dto) {
        String context = "";
        List<ArtPieceDTO> artPieces = dto.getArtPieces();
        List<Integer> epochIds = new LinkedList<>();
        List<Integer> movementIds = new LinkedList<>();
        List<Integer> authorIds = new LinkedList<>();
        if (artPieces.size() > 0) {
            for (ArtPieceDTO p : artPieces) {
                switch (dto.getRouteGenerality()) {
                    case "1":
                        if (p.hasEvent && !epochIds.contains(p.getEpoch().getid())) {
                            context += p.getEpoch().getEpochName() + ": " + p.getEpoch().getText1Epoch() + "\n";
                            epochIds.add(p.getEpoch().getid());
                        }
                        if (p.hasMovement && !movementIds.contains(p.getArtisticMovement().getid())) {
                            context += p.getArtisticMovement().getMovementName() + ": "
                                    + p.getArtisticMovement().getText1Movement() + "\n";
                            movementIds.add(p.getArtisticMovement().getid());
                        }
                        if (p.hasAuthor && !authorIds.contains(p.getAuthor().getid())) {
                            context += p.getAuthor().getNameAuthor() + ": " + p.getAuthor().getText1Author() + "\n";
                            authorIds.add(p.getAuthor().getid());
                        }
                        break;
                    case "2":
                        if (p.hasEvent && !epochIds.contains(p.getEpoch().getid())) {
                            context += p.getEpoch().getEpochName() + ": " + p.getEpoch().getText2Epoch() + "\n";
                            epochIds.add(p.getEpoch().getid());
                        }
                        if (p.hasMovement && !movementIds.contains(p.getArtisticMovement().getid())) {
                            System.out.println(p.getArtisticMovement().getMovementName() + ": "
                                    + p.getArtisticMovement().getText2Movement() + "\n");
                            context += p.getArtisticMovement().getMovementName() + ": "
                                    + p.getArtisticMovement().getText2Movement() + "\n";
                            movementIds.add(p.getArtisticMovement().getid());
                        }
                        if (p.hasAuthor && !authorIds.contains(p.getAuthor().getid())) {
                            context += p.getAuthor().getNameAuthor() + ": " + p.getAuthor().getText2Author() + "\n";
                            authorIds.add(p.getAuthor().getid());
                        }
                        break;
                    case "3":
                        if (p.hasEvent && !epochIds.contains(p.getEpoch().getid())) {
                            context += p.getEpoch().getEpochName() + ": " + p.getEpoch().getText3Epoch() + "\n";
                            epochIds.add(p.getEpoch().getid());
                        }
                        if (p.hasMovement && !movementIds.contains(p.getArtisticMovement().getid())) {
                            context += p.getArtisticMovement().getMovementName() + ": "
                                    + p.getArtisticMovement().getText3Movement() + "\n";
                            movementIds.add(p.getArtisticMovement().getid());
                        }
                        if (p.hasAuthor && !authorIds.contains(p.getAuthor().getid())) {
                            context += p.getAuthor().getNameAuthor() + ": " + p.getAuthor().getText3Author() + "\n";
                            authorIds.add(p.getAuthor().getid());
                        }
                        break;
                    default:
                        context += "";
                        break;
                }
            }
        }
        return context;
    }
}
