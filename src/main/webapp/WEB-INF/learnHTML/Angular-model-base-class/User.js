/**
 * Created by Nghia on 28-08-2016.
 */
'use strict';
var myApp = angular.module('myApp', []);
myApp.factory('User', function (Organization) {
    /**
     * Private property
     */
    var possibleRoles = ['admin', 'editor', 'guest'];

    /*
     * Constructor with class name
     */
    function User(firstName, lastName, role, organization) {
        // Public properties, assigned to the instance ('this')
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.organization = organization;
    }

    /**
     * Public method, assigned to prototype
     */
    User.prototype.getFullName = function () {
        return this.firstName + this.lastName;
    }

    /**
     * Private function
     */
    function checkRole(roleInput) {
        return possibleRoles.indexOf(roleInput) !== -1;
    }

    /**
     * Static property
     * Using copy to prevent modifications to private property
     */
    User.possibleRoles = angular.copy(possibleRoles);
    /**
     * Static method, assigned to class
     * Instance ('this') is not available in static context
     */
    User.build = function (data) {
        if (!checkRole(data.role)) {
            return;
        }
        return new User(data.first_name, data.last_name, data.role, Oraganization.build(data.organization)) // another model
    }
    /**
     * Return the constructor function
     */
    return User;
})


