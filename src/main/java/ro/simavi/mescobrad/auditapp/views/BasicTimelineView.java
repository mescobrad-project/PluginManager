package ro.simavi.mescobrad.auditapp.views;

import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.timeline.TimelineSelectEvent;

import org.primefaces.model.timeline.TimelineEvent;
import org.primefaces.model.timeline.TimelineModel;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.time.LocalDate;

@Component("basicTimelineView")
@ViewScoped
@Getter
@Setter
public class BasicTimelineView
{
    private TimelineModel<String, ?> model;

    private boolean selectable = true;
    private boolean zoomable = true;
    private boolean moveable = true;
    private boolean stackEvents = true;
    private String eventStyle = "box";
    private boolean showCurrentTime = true;
    private boolean showNavigation = false;

    @PostConstruct
    protected void initialize() {
        model = new TimelineModel<>();

        model.add( TimelineEvent.<String>builder().data("PrimeUI 1.1").startDate( LocalDate.of(2014, 6, 12)).build());
        model.add(TimelineEvent.<String>builder().data("PrimeFaces 5.1.3").startDate(LocalDate.of(2014, 10, 11)).build());
        model.add(TimelineEvent.<String>builder().data("PrimeUI 2.2").startDate(LocalDate.of(2015, 12, 8)).build());
        model.add(TimelineEvent.<String>builder().data("Sentinel-Layout 1.1").startDate(LocalDate.of(2015, 3, 10)).build());
        model.add(TimelineEvent.<String>builder().data("Spark-Layout 1.0").startDate(LocalDate.of(2015, 4, 3)).build());
        model.add(TimelineEvent.<String>builder().data("Ronin-Layout 1.0").startDate(LocalDate.of(2015, 5, 15)).build());
        model.add(TimelineEvent.<String>builder().data("Modena-Layout 1.0").startDate(LocalDate.of(2015, 7, 10)).build());
        model.add(TimelineEvent.<String>builder().data("Rio-Layout 1.0").startDate(LocalDate.of(2015, 6, 15)).build());
        model.add(TimelineEvent.<String>builder().data("Adamantium-Layout 1.0").startDate(LocalDate.of(2015, 9, 4)).build());
        model.add(TimelineEvent.<String>builder().data("Titan-Layout 1.0").startDate(LocalDate.of(2015, 12, 14)).build());
        model.add(TimelineEvent.<String>builder().data("Volt-Layout 1.0").startDate(LocalDate.of(2015, 10, 12)).build());
        model.add(TimelineEvent.<String>builder().data("Atlas-Layout 1.0").startDate(LocalDate.of(2016, 1, 28)).build());
        model.add(TimelineEvent.<String>builder().data("PrimeUI 4.1.0").startDate(LocalDate.of(2016, 2, 24)).build());
        model.add(TimelineEvent.<String>builder().data("PrimeFaces 5.3.8").startDate(LocalDate.of(2016, 2, 29)).build());
        model.add(TimelineEvent.<String>builder().data("PrimeNG 0.5").startDate(LocalDate.of(2016, 2, 29)).build());
    }
    public void onSelect( TimelineSelectEvent<String> e) {
        TimelineEvent<String> timelineEvent = e.getTimelineEvent();

        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected event:", timelineEvent.getData());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
