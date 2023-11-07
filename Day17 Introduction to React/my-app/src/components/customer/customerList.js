import React, { Component } from "react";

import customerjson from "./customers.json";
import CustomerDetails from "./customerDetails";
import CustomerForm from "./customerForm";

class CustomerList extends Component {
  constructor(props) {
    super(props);
    this.addCustomer = this.addCustomer.bind(this);
    this.state = {
      customers: customerjson,
      selectedCustomer: {"id":0}
    };
  }

  addCustomer(newCustomer) {
    const totalCustomers = this.state.customers.length;
    newCustomer.id = totalCustomers + 1;
    const newList = [...this.state.customers, newCustomer]
    this.setState({
      customers: newList,
    });
  }
  onCustomerSelect(e,customer) {
    console.log("selected customer :",customer.id);
    this.setState({
      selectedCustomer: customer,
    });
  }

  tabRow() {
    const tableRows = this.state.customers.map((customer, i) => {
      return (
        <tr onClick={e => this.onCustomerSelect(e, customer)} key={i}>
          <td>{customer.id}</td>
          <td>{customer.firstName}</td>
          <td>{customer.lastName}</td>
          <td>{customer.email}</td>
        </tr>
      );
    });

    return tableRows;
  }
  render() {
    return (
      <div className="container">
        <h2> Customers List</h2>
        {/* <h3> {customers[0].id}</h3> */}
        <table className="table table-striped table-hover table-sm table-bordered">
          <thead>
            <tr className="table-dark">
              <td>ID</td>
              <td>FirstName</td>
              <td>LastName</td>
              <td>Email</td>
            </tr>
          </thead>
          <tbody>{this.tabRow()}</tbody>
        </table>
        <div className="row">
          <div className="col-md-6">
            <CustomerForm addCustomer={this.addCustomer} />
          </div>
          <div className="col-md-2"></div>
          <div className="col-md-4">
            {this.state.selectedCustomer.id !== 0 && <CustomerDetails customer={this.state.selectedCustomer} /> }
          </div>
        </div>
      </div>
    );
  }
}

export default CustomerList;
