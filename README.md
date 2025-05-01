# Fetch Rewards Coding Exercise - Android

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-0095D5?style=for-the-badge&logo=kotlin&logoColor=white)

## 📱 App Overview

This Android application retrieves and displays item data from the Fetch Rewards API, implementing the following requirements:

- Fetches data from `https://fetch-hiring.s3.amazonaws.com/hiring.json`
- Groups items by their `listId`
- Sorts items first by `listId` then by `name`
- Filters out items with blank or null names
- Displays results in a clean, scrollable list

## 🛠 Technical Implementation

### Architecture
- **MVVM (Model-View-ViewModel)** pattern
- **Repository pattern** for data handling
- **LiveData** for reactive UI updates
- **Retrofit** for network operations
- **RecyclerView** for efficient list display

### Key Components
| Component | Responsibility |
|-----------|---------------|
| `ItemRepository` | Handles data fetching, filtering, and sorting |
| `ItemViewModel` | Manages UI-related data |
| `ItemAdapter` | Binds data to RecyclerView |
| `MainActivity` | Sets up UI and observes data changes |

### Sorting Logic
1. **Primary Sort**: By `listId` (ascending)
2. **Secondary Sort**: By `name` with special handling:
   - Extracts numbers from names (e.g., "Item 123" → 123)
   - Numeric names sorted numerically (2 comes before 10)
   - Non-numeric names sorted alphabetically
   - Numeric names appear before non-numeric names

## 🚀 Getting Started

### Prerequisites
- Android Studio (latest stable version)
- Android SDK (API level 21+)
- Java 8+

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/fetch-rewards-android.git
