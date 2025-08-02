# 🚆 MakeMyTrip Train Ticket Booking Automation

This project automates the process of booking a train ticket on [MakeMyTrip](https://www.makemytrip.com) using **Java**, **Selenium WebDriver**, **Maven**, and the **Page Object Model (POM)** design pattern.

## 📌 Objective

Build a scalable and maintainable Selenium test framework to:

- Search for trains from **Vadodara** to **Surat** for the **upcoming Friday**, after **9 PM**, in **First AC class**.
- Extract and print all available train options and ticket prices.
- Add traveler details and proceed to book.
- Capture and display the error message shown due to the missing IRCTC account link.
- Print all details shown on the final "Pay & Book Now" screen.

## 📸 Test Scenario Overview

1. Open [makemytrip.com](https://www.makemytrip.com).
2. Click on the **Trains** section.
3. Enter journey details: From **Vadodara**, To **Surat**, Class: **First AC**, Date: **Upcoming Friday after 9 PM**.
4. Click **Search**.
5. Print all available train options and ticket prices.
6. Add traveler details.
7. Click **Pay and Book Now**.
8. Capture and print the **error message** due to missing IRCTC account.
9. Print all booking details shown on the screen.

---

## 🔧 Technologies Used

- **Java**
- **Selenium WebDriver**
- **Maven** (Project and dependency management)
- **WebDriverManager** (for managing browser drivers)
- **TestNG** (for test execution and assertions)
- **Page Object Model (POM)** (for scalable architecture)
- **Log4j / System.out.print** (for logging and visibility)
- **Optional: Allure / Extent Reports** (for advanced test reporting)

---

## 🚀 Setup Instructions

### Prerequisites

- Java 11 or higher
- Maven 3.6+
- Git
- IDE (IntelliJ IDEA / Eclipse recommended)
- Chrome or Firefox browser

### Steps to Run

```bash
# Clone the repo
git clone https://github.com/Dharmesh12793/MakeMyTrip_Practicle.git
cd MakeMyTrip_Practicle

# Run tests using Maven
mvn clean test
