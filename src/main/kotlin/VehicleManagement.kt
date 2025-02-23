/**
 * Created by Ritabrata
 */


import kotlinx.coroutines.*
import java.util.*
import kotlin.random.Random

// Sealed class defining different types of vehicle statuses
sealed class VehicleStatus {
    object Available : VehicleStatus()
    object InUse : VehicleStatus()
    object UnderMaintenance : VehicleStatus()
}

// Interface defining common behaviors for all vehicles
interface VehicleOperations {
    fun start()
    fun stop()
    fun refuel(amount: Double)
}

// Abstract class representing a generic Vehicle
abstract class Vehicle(
    val id: String,
    val type: String,
    var fuelCapacity: Double
) : VehicleOperations {

    var status: VehicleStatus = VehicleStatus.Available
    var fuelLevel: Double = fuelCapacity * 0.5  // Default to 50% fuel
    var distanceTraveled: Double = 0.0

    // Abstract method to calculate fuel efficiency
    abstract fun fuelEfficiency(): Double  // Km per liter

    override fun start() {
        if (fuelLevel <= 0) {
            println("$type [$id] cannot start! Fuel is empty.")
        } else {
            status = VehicleStatus.InUse
            println("$type [$id] started. Fuel level: ${"%.2f".format(fuelLevel)} liters")
        }
    }

    override fun stop() {
        status = VehicleStatus.Available
        println("$type [$id] has stopped.")
    }

    override fun refuel(amount: Double) {
        fuelLevel += amount
        if (fuelLevel > fuelCapacity) fuelLevel = fuelCapacity
        println("$type [$id] refueled. Current fuel level: ${"%.2f".format(fuelLevel)} liters")
    }

    // Drive function to consume fuel
    fun drive(distance: Double) {
        val requiredFuel = distance / fuelEfficiency()
        if (fuelLevel >= requiredFuel) {
            fuelLevel -= requiredFuel
            distanceTraveled += distance
            println("$type [$id] drove $distance km. Remaining fuel: ${"%.2f".format(fuelLevel)} liters")
        } else {
            println("$type [$id] cannot drive! Not enough fuel.")
        }
    }
}

// Car class extending Vehicle
class Car(id: String) : Vehicle(id, "Car", 50.0) {
    override fun fuelEfficiency(): Double = 15.0  // 15 km per liter
}

// Bike class extending Vehicle
class Bike(id: String) : Vehicle(id, "Bike", 15.0) {
    override fun fuelEfficiency(): Double = 40.0  // 40 km per liter
}

// Truck class extending Vehicle
class Truck(id: String) : Vehicle(id, "Truck", 120.0) {
    override fun fuelEfficiency(): Double = 5.0  // 5 km per liter
}

// Vehicle Factory using Companion Object
class VehicleFactory {
    companion object {
        fun createVehicle(type: String, id: String): Vehicle {
            return when (type.lowercase()) {
                "car" -> Car(id)
                "bike" -> Bike(id)
                "truck" -> Truck(id)
                else -> throw IllegalArgumentException("Invalid vehicle type: $type")
            }
        }
    }
}

// Data class to store trip records
data class Trip(val vehicleId: String, val distance: Double, val fuelConsumed: Double, val date: Date)

// Trip manager to handle vehicle trips
object TripManager {
    private val trips = mutableListOf<Trip>()

    fun recordTrip(vehicle: Vehicle, distance: Double) {
        val fuelUsed = distance / vehicle.fuelEfficiency()
        trips.add(Trip(vehicle.id, distance, fuelUsed, Date()))
        println("Trip recorded: ${vehicle.type} [${vehicle.id}] - Distance: $distance km, Fuel: ${"%.2f".format(fuelUsed)} liters")
    }

    fun displayTripHistory() {
        println("\n---- Trip History ----")
        trips.forEach { println(it) }
    }
}

// Maintenance Manager for vehicle service tracking
object MaintenanceManager {
    private val maintenanceRecords = mutableMapOf<String, MutableList<String>>()

    fun performMaintenance(vehicle: Vehicle) {
        vehicle.status = VehicleStatus.UnderMaintenance
        maintenanceRecords.putIfAbsent(vehicle.id, mutableListOf())
        maintenanceRecords[vehicle.id]?.add("Maintenance performed on ${Date()}")
        println("${vehicle.type} [${vehicle.id}] is under maintenance.")
    }

    fun showMaintenanceRecords(vehicleId: String) {
        println("\n---- Maintenance Records for Vehicle [$vehicleId] ----")
        maintenanceRecords[vehicleId]?.forEach { println(it) } ?: println("No maintenance records found.")
    }
}

// Coroutine-based logger for asynchronous operations
object Logger {
    fun log(message: String) {
        GlobalScope.launch {
            delay(Random.nextLong(500, 1500))  // Simulate delay
            println("[LOG] ${Date()} - $message")
        }
    }
}

// Main function to demonstrate all features
fun main() = runBlocking {
    val car1 = VehicleFactory.createVehicle("car", "C123")
    val bike1 = VehicleFactory.createVehicle("bike", "B456")
    val truck1 = VehicleFactory.createVehicle("truck", "T789")

    Logger.log("Vehicles initialized successfully")

    car1.start()
    car1.drive(30.0)
    TripManager.recordTrip(car1, 30.0)
    car1.refuel(10.0)
    car1.stop()

    bike1.start()
    bike1.drive(60.0)
    TripManager.recordTrip(bike1, 60.0)
    bike1.stop()

    truck1.start()
    truck1.drive(100.0)
    TripManager.recordTrip(truck1, 100.0)
    truck1.refuel(50.0)
    truck1.stop()

    // Maintenance
    MaintenanceManager.performMaintenance(car1)
    MaintenanceManager.performMaintenance(truck1)
    MaintenanceManager.showMaintenanceRecords("C123")

    // Display trip history
    TripManager.displayTripHistory()

    // Wait for async logs to finish
    delay(2000)
}
