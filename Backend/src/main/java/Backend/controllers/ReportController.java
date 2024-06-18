package Backend.controllers;

import Backend.dto.ReportDTO;
import Backend.services.ReportService;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/report")
@CrossOrigin
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping("/generateReport/")
    public void generateReport(@RequestBody ReportDTO dto, HttpServletResponse response)
            throws IOException, ChangeSetPersister.NotFoundException, JRException {
        if (dto.getArtPieces() == null || dto.getArtPieces().isEmpty()) {
            throw new ChangeSetPersister.NotFoundException();
        }

        JasperPrint report = reportService.createReport(dto);
        if (report == null) {
            throw new ChangeSetPersister.NotFoundException();
        }
        JasperExportManager.exportReportToPdfStream(report, response.getOutputStream());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleException(RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
