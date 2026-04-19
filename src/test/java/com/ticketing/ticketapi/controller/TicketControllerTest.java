package com.ticketing.ticketapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketing.ticketapi.model.Ticket;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TicketController.class)
class TicketControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private Ticket buildIncomingTicket() {
        Ticket ticket = new Ticket();
        ticket.setRequestorName("John Doe");
        ticket.setTicketDescription("Login button is broken");
        ticket.setCompanyName("Acme Corp");
        ticket.setPriority("HIGH");
        ticket.setAssigneeName("Jane Smith");
        ticket.setAssigneeEmail("jane.smith@acme.com");
        return ticket;
    }

    @Test
    void createTicket_returnsOkWithAllFieldsPopulated() throws Exception {
        Ticket incoming = buildIncomingTicket();

        mockMvc.perform(post("/ticket")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(incoming)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.requestorName").value("John Doe"))
                .andExpect(jsonPath("$.ticketDescription").value("Login button is broken"))
                .andExpect(jsonPath("$.companyName").value("Acme Corp"))
                .andExpect(jsonPath("$.priority").value("HIGH"))
                .andExpect(jsonPath("$.assigneeName").value("Jane Smith"))
                .andExpect(jsonPath("$.assigneeEmail").value("jane.smith@acme.com"))
                .andExpect(jsonPath("$.status").value("success"))
                .andExpect(jsonPath("$.creationDate").isNotEmpty());
    }

    @Test
    void createTicket_setsCreationDateToToday() throws Exception {
        Ticket incoming = buildIncomingTicket();

        MvcResult result = mockMvc.perform(post("/ticket")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(incoming)))
                .andExpect(status().isOk())
                .andReturn();

        Ticket response = objectMapper.readValue(result.getResponse().getContentAsString(), Ticket.class);
        assertThat(response.getCreationDate()).isEqualTo(LocalDate.now().toString());
    }

    @Test
    void createTicket_setsStatusToSuccess() throws Exception {
        Ticket incoming = buildIncomingTicket();

        MvcResult result = mockMvc.perform(post("/ticket")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(incoming)))
                .andExpect(status().isOk())
                .andReturn();

        Ticket response = objectMapper.readValue(result.getResponse().getContentAsString(), Ticket.class);
        assertThat(response.getStatus()).isEqualTo("success");
    }

    @Test
    void createTicket_ignoresIncomingCreationDateAndStatus() throws Exception {
        Ticket incoming = buildIncomingTicket();
        incoming.setCreationDate("2000-01-01");
        incoming.setStatus("pending");

        MvcResult result = mockMvc.perform(post("/ticket")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(incoming)))
                .andExpect(status().isOk())
                .andReturn();

        Ticket response = objectMapper.readValue(result.getResponse().getContentAsString(), Ticket.class);
        assertThat(response.getCreationDate()).isEqualTo(LocalDate.now().toString());
        assertThat(response.getStatus()).isEqualTo("success");
    }
}
