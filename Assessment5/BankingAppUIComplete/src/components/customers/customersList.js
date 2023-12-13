import React from 'react';

import { Link } from 'react-router-dom';

import axios from 'axios';

class CustomersList extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            customersArray: null,
            selectedCustomer: ''
        }
        // this.onCustomerSelect = this.onCustomerSelect.bind(this);
        this.addCustomer = this.addCustomer.bind(this);
        this.deleteCustomer = this.deleteCustomer.bind(this);
    }


    componentDidMount() {
        console.log("Inside Component Did mount of Customers List");
        axios.get("http://localhost:8090/customer")
            .then(res => {
                console.log("Received Reponse :" + JSON.stringify(res.data));
                this.setState(
                    { customersArray: res.data }
                )
            })
            .catch(err => {
                console.log("Error :" + err);
            }).finally(
                console.log("I'm in finally")
            )
    }


    // onCustomerSelect(e, customer) {
    //     console.log("Entering into onCustomerSelect Method");
    //     this.setState({
    //         selectedCustomer: customer
    //     })
    // }

    deleteCustomer(evt, customerId) {
        evt.preventDefault();

        axios.delete(`http://localhost:8090/customer/${customerId}`)
            .then(res => {
                console.log("Received Reponse :" + JSON.stringify(res.data));
                let updatedCustomer = [...this.state.customersArray].filter(cust => cust.id !== customerId)
                this.setState(
                    { customersArray: updatedCustomer }
                )
            })
            .catch(err => {
                alert("Delete Unsuccessful", err);
                console.log("Error :" + err);
            })
    }

    tabRow() {
        const tableRows = this.state.customersArray.map((customer, i) => {
            return (
                // <tr onClick={e => this.onCustomerSelect(e, customer)} key={customer.id}>
                <tr key={i}>
                    <td>{customer.id}</td>
                    <td>{customer.firstName}</td>
                    <td>{customer.lastName}</td>
                    <td>{customer.email}</td>
                    <td>
                        <Link className="ui basic blue button" to={`/customers/${customer.id}`} >Show</Link> |
                        <Link className="ui basic blue button" to={`/customers/${customer.id}/edit`} >Edit</Link> |
                        <Link className="ui basic blue button" onClick={evt => this.deleteCustomer(evt, customer.id)} >Delete</Link>
                    </td>
                </tr>
            );
        });
        return tableRows;
    }

    addCustomer(newCustomer) {
        const totalCustomers = this.state.customersArray.length;
        newCustomer.id = totalCustomers + 1;
        let newCustomerList = [...this.state.customersArray];
        newCustomerList.push(newCustomer);
        this.setState({
            customersArray: newCustomerList
        });
    }



    render() {
        return (
            <div className="container">
                <Link color="primary" to="/new/customers">
                    Create New Customer
                </Link>
                <br />
                <hr />
                <h3>Customers List</h3>
                <table className="table table-hover table-striped table-bordered table-sm">
                    <thead className="thead-dark">
                        <tr>
                            <th>ID</th>
                            <th>FirstName</th>
                            <th>LastName</th>
                            <th>Email</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {this.state.customersArray?this.tabRow():null}
                    </tbody>
                </table>
                <br />
                <br />
                <hr />
                {/* <div className="row">
                    <div className="col-md-6">
                        <CustomerForm addCustomer={this.addCustomer} />
                    </div>
                    <div className="col-md-2"></div>
                    <div className="col-md-4">
                        {this.state.selectedCustomer ? <CustomerDetails customer={this.state.selectedCustomer} /> : null}
                    </div>
                </div> */}
            </div>
        );
    }
}

export default CustomersList;