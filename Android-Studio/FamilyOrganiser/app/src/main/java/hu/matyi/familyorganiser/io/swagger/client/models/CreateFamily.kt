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


/**
 * 
 * @param name 
 * @param headId 
 * @param memberIds 
 * @param code 
 */
data class CreateFamily (
    val name: kotlin.String,
    val code: kotlin.String,
    val headId: kotlin.Long? = null,
    val memberIds: kotlin.Array<kotlin.Long>? = null
) {

}
