# CFG
Android application for loading, storing, displaying, and editing products.

## Features
- Load products from remote API
- Store products in Room database
- Display products list
- Edit product name and description
- Persist changes locally
- Automatic UI updates via Flow

## Tech Stack
- Kotlin
- MVVM
- Data Binding
- Navigation Component (XML Navigation Graph, legacy version)
- Hilt
- Retrofit
- Room
- Coroutines
- LiveData
- Glide

## Modern Alternatives
The project follows the requirements of the test task.

For a modern Android application, the following technologies could be considered:
- Jetpack Compose instead of XML + Data Binding
- StateFlow and SharedFlow instead of LiveData
- Compose Navigation instead of Fragment-based Navigation

## Architecture
├───data
│   ├───local
│   │   ├───dao
│   │   ├───database
│   │   ├───entity
│   │   └───relation
│   ├───mapper
│   ├───remote
│   │   ├───api
│   │   └───dto
│   └───repository
├───di
├───domain
│   ├───model
│   └───repository
└───presentation
    ├───editProduct
    │   └───model
    ├───loadProducts
    │   └───model
    ├───navigation
    └───products
        ├───adapter
        ├───mapper
        └───model

## API
https://fake-store-api.mock.beeceptor.com/api/products
Note: Product image URLs provided by the API are placeholders and may not return actual images.

## Screens

### Load Products
Loads products from API and stores them in Room.

### Products
Displays products from Room database.

### Edit Product
Allows editing product name and description.