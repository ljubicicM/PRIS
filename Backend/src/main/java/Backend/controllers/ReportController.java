package Backend.controllers;

import Backend.model.ArtPiece;
import Backend.services.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/report")
@CrossOrigin
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping("/generateReport")
    public ResponseEntity<?> generateReport(@RequestParam String routeString, @RequestBody List<ArtPiece> arrayArtPiece) throws IOException, ChangeSetPersister.NotFoundException, JRException {
        if (arrayArtPiece == null || arrayArtPiece.isEmpty()) {
            throw new ChangeSetPersister.NotFoundException();
        }

        byte[] report = reportService.createReport(routeString, arrayArtPiece);
        if (report == null) {
            throw new ChangeSetPersister.NotFoundException();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "artPiecesReport.pdf");
        return ResponseEntity.ok()
                .headers(headers)
                .body(report);
    }

}
