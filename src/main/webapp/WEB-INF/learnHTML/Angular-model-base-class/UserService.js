/**
 * Created by Nghia on 28-08-2016.
 *
 * The most common place to create model objects is in services.
 * I often find myself writing services for most of the models in my application.
 * This is because models usually reflect a data resource (in RESTful terms),
 * so it makes sense to have a service which acts on the API endpoint for this resource.
 * For example, a basic OrganisationService:
 */
'use strict';
var myApp = angular.module('myApp2', []);
myApp.factory('OrganizationService', function (API, Organization) {
    return {
        get: function () {
            return API.get('oraganizations').then(Organizaion.apiResponseTransformer);
        }
    }
}

/*
 * The API service is just a wrapper for $http and returns a promise with the data of the response instead of the
 * entire response (including headers and such). The most interesting to note here is the static method
 * Organisation.apiResponseTransformer, which is passed as the callback function to then().
 * The goal is to have all of the organisations returned by the API to be mapped to the Organisation model.
 * This allows you to verify the response data and enhance it with additional properties and methods.
 * An apiResponseTransformer may look like this:
 * */
