package com.example.arxiv.data

class UserRepository (
    private val userDAO: UserDAO) {
    suspend fun getUsers() : List<User> {
        return userDAO.getUsers()
    }

    fun insertUser(user: User) {
        userDAO.insertUser(user)
    }
}