package com.example.messenagerapp

data class AddMembersRequest(
    val chatId: Int,
    val membersIds: List<Int>
)