// Project Configuration File for Decentralized Machine Learning Model Simulator

import kotlin.random.Random

// Configuration Properties
object Config {
    // Network properties
    const val numNodes = 10
    const val blockchainType = "Ethereum"
    const val consensusAlgorithm = "Proof of Stake"

    // Model properties
    const val modelType = "Neural Network"
    const val inputDimensions = 784
    const val outputDimensions = 10
    const val hiddenLayers = 2
    const val hiddenUnits = 256

    // Training properties
    const val batchSize = 32
    const val epochs = 10
    const val learningRate = 0.01

    // Simulation properties
    const val numSimulations = 100
    const val simulationDuration = 60 // in seconds
}

// Node properties
data class Node(val id: Int, val ipAddress: String, val modelName: String)

// Blockchain properties
data class Block(val index: Int, val transactions: List<Transaction>)
data class Transaction(val sender: Node, val recipient: Node, val modelUpdate: ModelUpdate)

// Model properties
data class Model(val id: Int, val type: String, val parameters: List<Double>)
data class ModelUpdate(val modelId: Int, val updates: List<Double>)

// Simulator properties
object Simulator {
    val nodes: MutableList<Node> = mutableListOf()
    val blockchain: MutableList<Block> = mutableListOf()
    val models: MutableList<Model> = mutableListOf()

    init {
        // Initialize nodes
        for (i in 1..Config.numNodes) {
            nodes.add(Node(i, "192.168.1.${i}", "Model-${i}"))
        }

        // Initialize blockchain
        blockchain.add(Block(0, listOf()))

        // Initialize models
        for (i in 1..Config.numNodes) {
            models.add(Model(i, Config.modelType, List(Config.inputDimensions) { Random.nextDouble() }))
        }
    }
}