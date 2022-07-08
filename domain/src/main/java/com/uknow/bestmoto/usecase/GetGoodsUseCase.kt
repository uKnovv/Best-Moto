package com.uknow.bestmoto.usecase

import com.uknow.bestmoto.model.Item
import com.uknow.bestmoto.util.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetGoodsUseCase {
    suspend operator fun invoke(): Flow<Resource<List<Item>>> {
        return flow {
            emit(Resource.Loading(isLoading = true))

            delay(3000) // ! Delete this later !

            emit(Resource.Success(data = listOf(
                (Item("Honda СB300R", "", 150, "", "", "", hashMapOf(), 0)),
                (Item("BMW G 310 R",  "", 150, "", "", "", hashMapOf(), 0)),
                (Item("Kawasaki VERSYS-X 300", "", 150, "", "", "", hashMapOf(), 0 )),
                (Item("Yamaha YBR125",  "", 150, "", "", "", hashMapOf(), 0)),
            )))

            emit(Resource.Loading(isLoading = false))
        }
    }
}