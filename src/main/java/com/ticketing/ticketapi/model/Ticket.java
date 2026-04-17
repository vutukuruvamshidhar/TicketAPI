package com.ticketing.ticketapi.model;

import java.time.LocalDate;

public class Ticket {

    private String requestorName;
    private String ticketDescription;
    private String companyName;
    private String priority;
    private String assigneeName;
    private String assigneeEmail;
    private LocalDate creationDate;
    private String status;

    public Ticket() {}

    public Ticket(String requestorName, String ticketDescription, String companyName,
                  String priority, String assigneeName, String assigneeEmail,
                  LocalDate creationDate, String status) {
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

    public LocalDate getCreationDate() { return creationDate; }
    public void setCreationDate(LocalDate creationDate) { this.creationDate = creationDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
