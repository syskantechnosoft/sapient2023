import React, { useState } from "react";
import { Link } from "react-router-dom";
import customerArray from "../../model/customer.json";

const CustomerList = () => {
  const [customers, setCustomers] = useState(customerArray);
  
  function tabRow() {
    const tableRows = customers.map((customer, i) => {
      return (
       
        <tr key={i}>
          {/* Add missing code here */}
          <td>
            <Link
              className="ui basic blue button"
              to={`/customers/${customer.id}`}
            >
              Show
            </Link>{" "}            
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
