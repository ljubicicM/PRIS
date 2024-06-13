package Backend.services;

import Backend.model.ArtPiece;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

public byte[] createReport(String routeString, List<ArtPiece> arrayArtPiece) throws JRException, IOException {
    if (arrayArtPiece.isEmpty()) {
        return null;
    }

    JRBeanCollectionDataSource dataSource = createDataSource(arrayArtPiece);
    JasperReport jasperReport = compileReport();
    Map<String, Object> params = createParameters(routeString);
    JasperPrint jasperPrint = fillReport(jasperReport, params, dataSource);

    return exportReportToPdf(jasperPrint);
}

    private JRBeanCollectionDataSource createDataSource(List<ArtPiece> arrayArtPiece) {
        return new JRBeanCollectionDataSource(arrayArtPiece);
    }

    private JasperReport compileReport() throws JRException, IOException {
        InputStream inputStream = this.getClass().getResourceAsStream("/jasperreports/PrisReport.jrxml");
        if (inputStream == null) {
            System.out.println("nije ucitao");
        } else {
            System.out.println("ucitao je");
        }
        try {
            return JasperCompileManager.compileReport(inputStream);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    private Map<String, Object> createParameters(String routeString) {
        Map<String, Object> params = new HashMap<>();
        params.put("routeString", routeString);
        return params;
    }

    private JasperPrint fillReport(JasperReport jasperReport, Map<String, Object> params, JRBeanCollectionDataSource dataSource) throws JRException {
        return JasperFillManager.fillReport(jasperReport, params, dataSource);
    }

    private byte[] exportReportToPdf(JasperPrint jasperPrint) throws JRException, IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        JRPdfExporter exporter = new JRPdfExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(byteArrayOutputStream));
        exporter.exportReport();
        return byteArrayOutputStream.toByteArray();
    }

}
