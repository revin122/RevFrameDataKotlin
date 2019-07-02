package com.revinper.revframedata.Model


data class FGCharacter(val name : String = "",
                       val image : String = "",
                       val movelist : String = "") {

    override fun toString(): String {
        return "FGCharacter: $name, $image, ${movelist.length}"
    }

}