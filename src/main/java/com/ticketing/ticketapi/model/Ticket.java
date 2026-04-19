package com.ticketing.ticketapi.model;

public class Ticket {

    private String requestorName;
    private String ticketDescription;
    private String companyName;
    private String priority;
    private String assigneeName;
    private String assigneeEmail;
    private String creationDate;
    private String status;

    public Ticket() {}

    public Ticket(String requestorName, String ticketDescription, String companyName,
                  String priority, String assigneeName, String assigneeEmail,
                  String creationDate, String status) {
        this.requestorName = requestorName;
        this.ticketDescription = ticketDescription;
        this.companyName = companyName;
        this.priority = priority;
        this.assigneeName = assigneeName;
        this.assigneeEmail = assigneeEmail;
        this.creationDate = creationDate;
        this.status = status;
    }

    public String getRequestorName() { return requestorName; }
    public void setRequestorName(String requestorName) { this.requestorName = requestorName; }

    public String getTicketDescription() { return ticketDescription; }
    public void setTicketDescription(String ticketDescription) { this.ticketDescription = ticketDescription; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public String getAssigneeName() { return assigneeName; }
    public void setAssigneeName(String assigneeName) { this.assigneeName = assigneeName; }

    public String getAssigneeEmail() { return assigneeEmail; }
    public void setAssigneeEmail(String assigneeEmail) { this.assigneeEmail = assigneeEmail; }

    public String getCreationDate() { return creationDate; }
    public void setCreationDate(String creationDate) { this.creationDate = creationDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
