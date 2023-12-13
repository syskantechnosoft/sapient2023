import React from "react";

import { Link } from "react-router-dom";
import axios from "axios";
class CustomerForm extends React.Component {
  initialValue = {
    firstName: "",
    lastName: "",
    email: "",
    phone: "",
  };
  constructor(props) {
    super(props);
    this.state = {
      customer: this.initialValue,
      done: false,
    };
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleChange = this.handleChange.bind(this);
  }

  componentDidMount = () => {
    const custId = this.props.match.params.id;
    if (custId) {
      axios
        .get("http://localhost:8090/customer/" + custId)
        .then((res) => {
          this.setState({
            customer: res.data,
          });
        })
        .catch((err) => {
          console.log("Error" + err);
        });
    }
  };

  handleChange(evt) {
    const value = evt.target.value;
    const name = evt.target.name;
    let customer = { ...this.state.customer };
    customer[name] = value;
    this.setState({ customer });
  }

  handleSubmit(evt) {
    evt.preventDefault();
    const customer = this.state.customer;
    // this.props.addCustomer(newCustomer);
    if (customer.id) {
      const custId = customer.id;
      axios
        .put("http://localhost:8090/customer/" + custId, customer)
        .then((res) => {
          this.setState({ done: true });
          console.log("Successfully Updated");
        })
        .catch((err) => {
          console.log("error during update:" + err);
        });
    } else {
      axios
        .post("http://localhost:8090/customer/", customer)
        .then((res) => {
          this.setState({ done: true });
          console.log("Successfully Inserted");
        })
        .catch((err) => {
          console.log("error during insert :" + err);
        });
    }
  }

  getCustomerForm() {
    const custForm = (
      <form>
        <div className="form-group row">
          <label for="colFormLabelSm" className="col-sm-2 col-form-label ">
            FirstName
          </label>
          <div className="col-md-6">
            <input
              type="text"
              name="firstName"
              value={this.state.customer.firstName}
              onChange={this.handleChange}
              className="form-control"
              id="colFormLabelSm"
              placeholder="Enter First Name Here"
            />
          </div>
        </div>
        <div className="form-group row">
          <label for="colFormLabel" className="col-sm-2 col-form-label">
            LastName
          </label>
          <div className="col-md-6">
            <input
              type="text"
              name="lastName"
              value={this.state.customer.lastName}
              onChange={this.handleChange}
              className="form-control"
              id="colFormLabel"
              placeholder="Enter Last Name Here"
            />
          </div>
        </div>
        <div className="form-group row">
          <label for="colFormLabelLg" className="col-sm-2 col-form-label">
            Email
          </label>
          <div className="col-md-6">
            <input
              type="email"
              name="email"
              value={this.state.customer.email}
              onChange={this.handleChange}
              className="form-control "
              id="colFormLabelLg"
              placeholder="Enter Email Here"
            />
          </div>
        </div>
        <div className="form-group row">
          <label for="colFormLabelLg" className="col-sm-2 col-form-label">
            Phone
          </label>
          <div className="col-md-6">
            <input
              type="number"
              name="phone"
              value={this.state.customer.phone}
              onChange={this.handleChange}
              className="form-control "
              id="colFormLabelLg"
              placeholder="Enter Email Here"
            />
          </div>
        </div>
        <div>
          <button onClick={this.handleSubmit}> Submit</button>
        </div>
      </form>
    );
    return custForm;
  }

  render() {
    const backLineText = "< Back to Customers List";
    const formTitle = (
      <h2>{this.state.customer.id ? "Edit Customer" : "Add Customer"}</h2>
    );
    return (
      <div>
        <div className="row">
          <Link color="primary" to="/customers">
            {backLineText}
          </Link>
        </div>
        <hr />
        <div className="row">
          <div className="col-md-6">
            <h5>{formTitle}</h5>
            {this.state.done ? (
              <Link to={`/customers`} />
            ) : (
              this.getCustomerForm()
            )}
          </div>
        </div>
      </div>
    );
  }
}

export default CustomerForm;
