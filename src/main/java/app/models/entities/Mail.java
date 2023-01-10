package app.models.entities;

import java.util.List;
import java.util.Map;

public class Mail {
    private String nameTo;
    private String from;
    private String mailTo;

    private List<Object> attachments;
    private Map<String, Object> props;

    public Mail(String nameTo, String from, String mailTo, List<Object> attachments, Map<String, Object> props) {
        this.nameTo = nameTo;
        this.from = from;
        this.mailTo = mailTo;
        this.attachments = attachments;
        this.props = props;
    }

    public String getNameTo() {
        return nameTo;
    }

    public void setNameTo(String nameTo) {
        this.nameTo = nameTo;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMailTo() {
        return mailTo;
    }

    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }

    public List<Object> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Object> attachments) {
        this.attachments = attachments;
    }

    public Map<String, Object> getProps() {
        return props;
    }

    public void setProps(Map<String, Object> props) {
        this.props = props;
    }
}
