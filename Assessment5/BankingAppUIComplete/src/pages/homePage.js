import React, { Component } from 'react';

export default class HomePage extends Component {

    render() {
        return (
            <div className="jumbotron">
                <h1> Premier Bank - Admin Page</h1>
                <p> A Simple Customer Management App for Premier Bank</p>
                <hr />

                <p>Using the app, the admin can</p>
                <ul>
                    <li> View the List of Customers</li>
                    <li>Create, Update and Delete Customers</li>
                    <li>View Customer's account details</li>
                </ul>

            </div>
        );
    }
}