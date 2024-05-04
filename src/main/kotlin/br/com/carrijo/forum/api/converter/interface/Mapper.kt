package br.com.carrijo.forum.api.converter.`interface`

interface Mapper<E, F, V> {

    fun formToEntity(f: F): E
    fun entityToView(e: E): V
    fun entityListToViewList(eList: List<E>): List<V>

}