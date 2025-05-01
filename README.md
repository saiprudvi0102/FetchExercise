# Fetch Rewards Mobile Engineering Exercise

![Java](https://img.shields.io/badge/Java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Retrofit](https://img.shields.io/badge/Retrofit-2.9.0-blue.svg?style=for-the-badge)

## 📋 Project Overview

This Android application fulfills the exact requirements specified in the Fetch Rewards Mobile Engineering assessment:

- **Data Source**: Fetches JSON data from `https://hiring.fetch.com/hiring.json`
- **Display Requirements**:
  - Groups items by `listId`
  - Sorts by `listId` (ascending) then by `name` (numeric-aware)
  - Filters out items with blank/null names
- **Technical Requirements**:
  - Native Android app (Java)
  - Compatible with latest stable Android tools
  - Supports current Android OS versions

## 🏗 Implementation Details

### Data Processing Pipeline
1. **Fetch** → Retrieve JSON from Fetch's hiring endpoint
2. **Filter** → Remove items with blank/null names
3. **Sort** →
4. 4. **Display** → Clean RecyclerView presentation

### Key Components
| Component | Responsibility |
|-----------|---------------|
| `ApiClient` | Configures Retrofit with official endpoint |
| `ItemRepository` | Handles data fetching and processing |
| `ItemAdapter` | Efficient RecyclerView implementation |
| `MainActivity` | Sets up UI and observes LiveData |

## 🚀 Getting Started

### Prerequisites
- Android Studio Flamingo (2022.2.1) or later
- Android SDK 33+
- Java 17

### Installation
```bash
git clone https://github.com/yourusername/fetch-rewards-exercise.git
cd fetch-rewards-exercise
