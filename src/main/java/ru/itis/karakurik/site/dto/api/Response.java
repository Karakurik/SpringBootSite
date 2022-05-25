package ru.itis.karakurik.site.dto.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    @JsonProperty("messages")
    List<Message> messages;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Message {
        @JsonProperty("to")
        String to;

        @JsonProperty("messageCount")
        Integer messageCount;

        @JsonProperty("messageId")
        String messageId;

        @JsonProperty("status")
        List<Status> statuses;

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public class Status {
            @JsonProperty("groupId")
            Integer groupId;

            @JsonProperty("groupName")
            String groupName;

            @JsonProperty("id")
            Integer id;

            @JsonProperty("name")
            String name;

            @JsonProperty("description")
            String description;
        }
    }
}



