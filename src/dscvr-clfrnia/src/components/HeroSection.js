import React from 'react';
import '../App.css';
import {Buttons, TrailerButtons} from './Button';
import './HeroSection.css';


function HeroSection() {
    return (
        <div className='hero-container'>
            <video src='/videos/video-3.mp4' autoPlay="true" muted="false" loop="true"/>
            <h1>California is Waiting</h1>
            <p>What are you waiting for?</p>
            <div className='hero-btns'>
                <Buttons
                    className='btn'
                    buttonStyle='btn--outline'
                    buttonSize='btn--large'
                >
                    GET STARTED
                </Buttons>
                <TrailerButtons
                    className='btn'
                    buttonStyle='btn--primary'
                    buttonSize='btn--large'
                >
                    WATCH TRAILER <i className='far fa-play-circle'/>
                </TrailerButtons>
            </div>
        </div>
    );
}

export default HeroSection;