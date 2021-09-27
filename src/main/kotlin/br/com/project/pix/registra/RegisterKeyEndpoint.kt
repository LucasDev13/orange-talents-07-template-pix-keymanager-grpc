package br.com.project.pix.registra

import br.com.project.PixGrpcRequest
import br.com.project.PixGrpcResponse
import br.com.project.PixGrpcServiceGrpc
import io.grpc.stub.StreamObserver
import jakarta.inject.Inject

/**
 * Service - endpoint que recebe requests e envia reponses
 */
class RegisterKeyEndpoint(@Inject private val service: NewKeyPixService): PixGrpcServiceGrpc.PixGrpcServiceImplBase() {

    //sobreescrevo o service do protobuf
    override fun registerPixKey(request: PixGrpcRequest?, responseObserver: StreamObserver<PixGrpcResponse>?) {
        //realizo a lógica
        val newKey = request.toModel()//converto
        val keyCreated = service.register(newKey)//registra a chave executa toda a lógica e salvar os dados

        //retorno para o cliente
        responseObserver.onNext(PixGrpcResponse.newBuilder()
            .setClientId(keyCreated.clientId.toString())
            .setPixId(keyCreated.id.toString())
            .build())
        //finalizo a requisição grpc.
        responseObserver.onCompleted()
    }
}