import React from "react";
import {Buttons} from "./Button";
import "./Footer.css";
import {Link} from "react-router-dom";

function Footer(){
    return(
        <div className="footer-container">
            <section className="footer-subscription">
                <p className="footer-subscription-heading">
                    Join newsletter to receive our best updates.
                </p>
                <p className="footer-subsription-text">
                    You can unsub at anytime.
                </p>
                <div className="input-areas">
                    <form>
                        <input type="email" name="email" placeholder="Your Email" className="footer-input"/>
                        <Buttons buttonStyle="btn--outline">Subscribe</Buttons>
                    </form>
                </div>
            </section>
            <div className="footer-links">
                <div className="footer-link-wrapper">
                    <div className="footer-link-items">
                        <h2>About Us</h2>
                        <Link to="/sign-up"> How it works</Link>
                        <Link to="/"> Testimonials</Link>
                        <Link to="/"> Careers</Link>
                        <Link to="/"> Investors</Link>
                        <Link to="/"> Terms of Service</Link>
                    </div>
                    <div className="footer-link-items">
                        <h2>Applicants</h2>
                        <Link to="/sign-up"> Career Pathways</Link>
                        <Link to="/"> Upcoming Events</Link>
                        <Link to="/"> FAQs</Link>

                    </div>
                    <div className="footer-link-items">
                        <h2>Employers</h2>
                        <Link to="/sign-up"> Recast Your Workforce</Link>
                        <Link to="/"> Benefits</Link>

                    </div>
                    <div className="footer-link-items">
                        <h2>Connect</h2>
                        <Link to="/sign-up"> info@randomemail.com</Link>
                        <Link to="/"> (408)123-4567</Link>
                        <Link to="/"> Aurora Borealis Apt. A <br/>
                        Cool Lights, CL <br/>
                            90210
                        </Link>

                    </div>
                </div>
            </div>
        </div>
    )
}

export default Footer;