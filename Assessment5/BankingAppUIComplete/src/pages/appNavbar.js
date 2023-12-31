import React from 'react';
import { Link } from 'react-router-dom';

export default class AppNavBar extends React.Component {

    constructor(props) {
        super(props);
        this.state = { isOpen: false };
        this.toggle = this.toggle.bind(this);
    }

    toggle() {
        this.setState({
            isOpen: !this.state.isOpen
        })
    }
    render() {
        return (
            // <div classNameName="navbar navbar-inverse">
            //     <div classNameName="container-fluid">
            //         <div classNameName="navbar-header">
            //             <button type="button" classNameName="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false" >
            //                 <span classNameName="sr-only">Toggle Navigation</span>
            //                 <span classNameName="icon-bar" />
            //                 <span classNameName="icon-bar" />
            //                 <span classNameName="icon-bar" />
            //             </button>
            //             <Link classNameName="navbar-brand" to="/"> Premier Bank</Link>
            //         </div>

            //         <div classNameName="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            //             <ul classNameName="nav navbar-nav">
            //                 <li> <Link to="/">Home</Link></li>
            //                 <li>
            //                     <Link to="/customers">Customer</Link>
            //                 </li>
            //                 <li>
            //                     <Link to="/about">About</Link>
            //                 </li>
            //             </ul>

            //         </div>

            //     </div>
            // </div>
            <nav classNameName ="navbar navbar-expand-lg navbar-light bg-light">
                <a className="navbar-brand" href="#">Premier Bank</a>
                <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarNav">
                    <ul className="navbar-nav">
                        <li className="nav-item active">
                            <li> <Link to="/">Home</Link></li>
                            {/* <a className="nav-link" href="#">Home <span className="sr-only">(current)</span></a> */}
                        </li>
                        <li className="nav-item">
                            <Link to="/customers">Customer</Link>
                            {/* <a className="nav-link" href="#">Customer</a> */}
                        </li>
                        <li className="nav-item">
                            <Link to="/about">About</Link>
                            {/* <a className="nav-link" href="#">About</a> */}
                        </li>
                        {/* <li className="nav-item">
                            <a className="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                        </li> */}
                    </ul>
                </div>
            </nav>
        );
    }
}