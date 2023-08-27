package com.bruno.app


class CompareModel {

    fun compareStrings(string1: String, string2: String): String {

        return if(string1 == string2) {
           "Los textos son iguales"
        }else {
            "Los textos no son iguales"
        }
    }
}