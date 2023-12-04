package vega.odyssey.passpilot

data class PasswordItem(
    val id: Int,
    val username: String,
    val password: String,
    val site: String,
    val image: String
)