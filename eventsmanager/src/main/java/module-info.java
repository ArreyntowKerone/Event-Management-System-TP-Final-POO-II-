module com.example.eventmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.mail;  // For javax.mail
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
   
    
    requires javafx.graphics; // For LocalDateTime serialization
    requires org.slf4j; // For logging
    requires com.fasterxml.jackson.datatype.jsr310;
    // JUnit 5 dependencies (for testing)
    requires org.junit.jupiter.api;
    requires org.mockito;
    requires com.fasterxml.jackson.core; // Only if you're using Mockito
    opens com.example.eventmanager to javafx.fxml;
    exports com.example.eventmanager;
    opens com.example.eventmanager.usefulclasses; // For reflection
}
