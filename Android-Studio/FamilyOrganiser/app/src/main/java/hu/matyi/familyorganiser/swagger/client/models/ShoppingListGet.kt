/**
* Api Documentation
* Api Documentation
*
* OpenAPI spec version: 1.0
* 
*
* NOTE: This class is auto generated by the swagger code generator program.
* https://github.com/swagger-api/swagger-codegen.git
* Do not edit the class manually.
*/
package io.swagger.client.models

import io.swagger.client.models.ShoppingListItemPlain

/**
 * 
 * @param completed 
 * @param familyId 
 * @param fullPrice 
 * @param id 
 * @param items 
 */
data class ShoppingListGet (
    val completed: kotlin.Boolean,
    val familyId: kotlin.Long,
    val fullPrice: kotlin.Int,
    val id: kotlin.Long,
    val items: kotlin.Array<ShoppingListItemPlain>? = null
) {

}

