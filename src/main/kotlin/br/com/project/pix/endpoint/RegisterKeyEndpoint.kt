package br.com.project.pix.endpoint

import br.com.project.PixGrpcRequest
import br.com.project.PixGrpcResponse
import br.com.project.PixGrpcServiceGrpc
import br.com.project.pix.toModel
import io.grpc.stub.StreamObserver
import jakarta.inject.Singleton

/**
 * Service - endpoint que recebe requests e envia reponses
 */
@Singleton
class RegisterKeyEndpoint(): PixGrpcServiceGrpc.PixGrpcServiceImplBase() {

    //sobreescrevo o service do protobuf
    override fun registerPixKey(
        request: PixGrpcRequest,
        responseObserver: StreamObserver<PixGrpcResponse>
    ) {
        //realizo a lógica
        val newKey = request.toModel()
//        val keyCreated = service.register(newKey)//registra a chave executa toda a lógica e salvar os dados

        //retorno para o cliente
        responseObserver.onNext(PixGrpcResponse.newBuilder()
                                .setClientId(newKey.clientId.toString())
                                .setPixId(newKey.key.toString())
                                .build())
        //finalizo a requisição grpc.
        responseObserver.onCompleted()
    }
}