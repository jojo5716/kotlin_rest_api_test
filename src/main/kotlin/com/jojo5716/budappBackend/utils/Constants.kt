package com.jojo5716.budappBackend.utils

class Constants {
    companion object{
        private const val URL_API_BASE= "/api"
        private const val URL_API_VERSION= "/v1"
        private const val URL_BASE= "$URL_API_BASE$URL_API_VERSION"
        // Base API endpoint for accounts
        const val URL_BASE_ACCOUNTS = "$URL_BASE/accounts"
    }
}