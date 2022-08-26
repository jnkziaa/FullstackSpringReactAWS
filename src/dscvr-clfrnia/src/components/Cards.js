import React from "react";
import CardItem from "./CardItem";
import "./Cards.css"


function Cards(){
    return(
        <div className="cards">
            <h1>Preview California!</h1>
            <div className="cards__container">
                <div className="cards__wrapper">
                    <ul className="cards__items">
                        <CardItem
                            img src="images/img-2.JPG"
                            text="Explore the Sunset of California"
                            label="Adventure"
                            path="/services"
                        />
                        <CardItem
                            img src="images/img-3.JPG"
                            text="Unrivaled Beaches of California"
                            label="Adventure"
                            path="/services"
                        />
                        <CardItem
                            img src="images/img-4.JPG"
                            text="Waterfalls crafted by the Gods"
                            label="Adventure"
                            path="/services"
                        />
                        <CardItem
                            img src="images/img-5.JPG"
                            text="Luxurious Skyline of Los Angeles"
                            label="Adventure"
                            path="/services"
                        />
                    </ul>
                </div>
            </div>
        </div>

    );
}

export default Cards;