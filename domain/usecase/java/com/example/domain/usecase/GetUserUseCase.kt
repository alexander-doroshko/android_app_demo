package com.example.domain.usecase

import com.example.domain.model.User

class GetUserUseCase {
    fun execute(userId: String): User {
        // In a real app this would call a repository.
        // Returning hardcoded data for demo purposes.
        return User(
            id = userId,
            name = "Alice",
            email = "alice@example.com",
            avatarUrl = "",
        )
    }
}
