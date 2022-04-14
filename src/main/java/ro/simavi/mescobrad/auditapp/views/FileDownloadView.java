package ro.simavi.mescobrad.auditapp.views;

import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.stereotype.Component;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

@ViewScoped
@Component
@Getter
@Setter
public class FileDownloadView {

    private StreamedContent file;

    public FileDownloadView() {
        file = DefaultStreamedContent.builder()
                .name("downloaded_boromir.jpg")
                .contentType("image/jpg")
                .stream(() -> FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/demo/images/boromir.jpg"))
                .build();
    }

    public StreamedContent getFile() {
        return file;
    }
}
