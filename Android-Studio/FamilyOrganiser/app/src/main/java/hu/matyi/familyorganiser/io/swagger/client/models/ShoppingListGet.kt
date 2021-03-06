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

import io.swagger.client.models.GetShoppingListItem

/**
 * 
 * @param completed 
 * @param completedOn 
 * @param familyId 
 * @param fullPrice 
 * @param id 
 * @param items 
 * @param location 
 */
data class ShoppingListGet (
    val completed: kotlin.Boolean,
    val familyId: kotlin.Long,
    val fullPrice: kotlin.Int,
    val id: kotlin.Long,
    val location: kotlin.String,
    val completedOn: java.time.LocalDate? = null,
    val items: kotlin.Array<GetShoppingListItem>? = null
) {

}

