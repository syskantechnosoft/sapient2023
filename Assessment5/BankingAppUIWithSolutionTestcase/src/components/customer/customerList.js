import React, { useState } from "react";
import { Link } from "react-router-dom";
import customerArray from "../../model/customer.json";
// import axios from "axios";

const CustomerList = () => {
  const [customers, setCustomers] = useState(customerArray);
  const [selectedCustomer, setSelectedCustomer] = useState({ id: 0 });

  // function deleteCustomer(evt, customerId) {
  //   evt.preventDefault();

  //   axios
  //     .delete(`http://localhost:8090/customer/${customerId}`)
  //     .then((res) => {
  //       console.log("Received Reponse :" + JSON.stringify(res.data));
  //       let updatedCustomer = [...customers].filter(
  //         (cust) => cust.id !== customerId
  //       );
  //       setCustomers(updatedCustomer);
  //     })
  //     .catch((err) => {
  //       alert("Delete Unsuccessful", err);
  //       console.log("Error :" + err);
  //     });
  // }

  function tabRow() {
    const tableRows = customers.map((customer, i) => {
      return (
        // <tr onClick={e => this.onCustomerSelect(e, customer)} key={customer.id}>
        <tr key={i}>
          <td>{customer.id}</td>
          <td>{customer.firstName}</td>
          <td>{customer.lastName}</td>
          <td>{customer.email}</td>
          <td>{customer.mobile}</td>
          <td>
            {customer.address},{customer.city},{customer.state},
            {customer.country}
          </td>
          <td>
            <Link
              className="ui basic blue button"
              to={`/customers/${customer.id}`}
            >
              Show
            </Link>{" "}
            {/* |
            <Link
              className="ui basic blue button"
              to={`/customers/${customer.id}/edit`}
            >
              Edit
            </Link>{" "}
            |
            <Link
              className="ui basic blue button"
              onClick={(evt) => deleteCustomer(evt, customer.id)}
            >
              Delete
            </Link> */}
          </td>
        </tr>
      );
    });
    return tableRows;
  }

  return (
    <div>
      Customer List Component!!!
      <div className="container">
        {/* <Link color="primary" to="/new/customers">
          Create New Customer
        </Link> */}
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
              <th>Mobile</th>
              <th>Address</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>{customers ? tabRow() : null}</tbody>
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
            {this.state.selectedCustomer ? (
              <CustomerDetails customer={this.state.selectedCustomer} />
            ) : null}
          </div>
        </div> */}
      </div>
    </div>
  );
};

export default CustomerList;
