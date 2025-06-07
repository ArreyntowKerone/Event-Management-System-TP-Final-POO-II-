# **Event Management System (EMS)**  
*A Distributed Event Management System with JSON Persistence*  

---

## **📌 Project Overview**  
This Java application is a **Distributed Event Management System** that allows users to:  
✅ Create and manage **events** (Conferences, Concerts)  
✅ Register **participants** for events  
✅ Store data persistently in **JSON files**  
✅ Send email notifications (via JavaMail)  

Built with **JavaFX** for the UI and **JSR-353 (JSON-P)** for manual JSON serialization.  

---

## **⚙️ Features**  
### **Core Functionality**  
- **Event Management**  
  - Create, update, delete events (Conferences & Concerts)  
  - Polymorphic storage (handles different event types)  
- **Participant Registration**  
  - Separate participant lists for each event type  
- **Data Persistence**  
  - Auto-saves to JSON files (`events.json`, `participants.json`)  
  - Loads previous data on startup  

### **Technical Highlights**  
- **Manual JSON Handling** (using `javax.json`)  
- **Separation of Concerns** (UI, Business Logic, Data Layer)  
- **Email Notifications** (via SMTP)  

---

# **🚀 Setup & Run**  
### **Prerequisites**  
- Java **17+** (for JavaFX)  
- Maven  

### **Steps**  
1. **Clone the repo**  
   ```bash
   git clone https://github.com/your-repo/event-management-system.git
   cd event-management-system
   ```

2. **Build with Maven**  
   ```bash
   mvn clean install
   ```

3. **Run the application**  
   ```bash
   mvn javafx:run
   ```

4. **Configure Email (Optional)**  
   Edit `EmailService.java` with your SMTP credentials.  

---

## **📝 JSON Data Format Examples**  
### **Concert Example** (`concerts.json`)  
```json
[
  {
    "type": "concert",
    "id": "evt-001",
    "title": "Rock Festival 2024",
    "date": "2024-07-20T19:30:00",
    "artist": "The Rolling Stones",
    "genre": "Rock"
  }
]
```

### **Participant Example** (`concert_participants.json`)  
```json
[
  {
    "id": "part-001",
    "name": "Alice Smith",
    "email": "alice@example.com"
  }
]
```

---

## **🔧 Troubleshooting**  
| Issue | Solution |  
|-------|----------|  
| JSON files not saving? | Check write permissions in `/src/main/resources/`. |  
| Emails failing? | Verify SMTP settings in `EmailService.java`. |  
| JavaFX not loading? | Ensure Java 17+ and `javafx-maven-plugin` is configured. |  

---

## **📜 License**  
MIT License © 2024. Free for academic and personal use.  

---

**🎯 Developed for Educational Purposes**  
*University Project - Advanced OOP Concepts*
