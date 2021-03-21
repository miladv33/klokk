package com.theapache64.kineticwallclock.movement

import com.theapache64.kineticwallclock.COLUMNS
import com.theapache64.kineticwallclock.ROWS
import com.theapache64.kineticwallclock.model.ClockData

/**
 * To hold all set of animations
 */
abstract class MatrixGenerator<out T : Movement>(
    val data: T,
) {
    companion object {
        /**
         * To check if the returned matrix match the clock matrix
         */
        protected fun verifyIntegrityAndReturn(degreeMatrix: List<List<ClockData>>): List<List<ClockData>> {
            for (matrix in degreeMatrix) {
                require(matrix.size == COLUMNS) { "Column size should be $COLUMNS but found ${matrix.size}" }
            }
            require(degreeMatrix.size == ROWS) { "Row size should be $ROWS but found ${degreeMatrix.size}" }
            return degreeMatrix
        }
    }

    protected abstract fun generateMatrix(): List<List<ClockData>>

    fun getVerifiedMatrix(): List<List<ClockData>> {
        return verifyIntegrityAndReturn(generateMatrix())
    }

}