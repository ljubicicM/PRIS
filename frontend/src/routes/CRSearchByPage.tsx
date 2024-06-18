/* eslint-disable react-hooks/exhaustive-deps */
import React, { useEffect, useState } from 'react';
import './styles/routePages.css';
import { Dropdown } from '../components/dropdownComponent/dropdown';
import axios from 'axios';
import { Button } from '../components/buttonComponent/Button';
import artPiecePlaceholder from '../assets/images/artPiecePlaceholder.jpg';
import { useNavigate } from 'react-router-dom';

export const CRSearchByPage = () => {
    const navigate = useNavigate();
    const [isInitialized, setIsInitialized] = useState(false);
    const [yearsCreated, setYearsCreated] = useState([]);
    const [epochs, setEpochs] = useState([]);
    const [authors, setAuthors] = useState([]);
    const [artPieces, setArtPieces] = useState([]);
    const [selectedArtPieces, setSelectedArtPieces] = useState([]);

    const [dropdownValueYear, setDropdownValueYear] = useState(1);
    const [dropdownValueEpoch, setDropdownValueEpoch] = useState(1);
    const [dropdownValueAuthor, setDropdownValueAuthor] = useState(1);

    const [hours, setHours] = useState(0);
    const [minutes, setMinutes] = useState(0);

    const loadYearsCreated = async () => {
        const response = await axios.get('http://localhost:8082/artPiece/yearsCreated')
        if (response.data) {
            setYearsCreated(response.data.map((year: number) => { return { id: year, value: year.toString() } }));
        }

        else {
            console.log('Error loading years created');
        }
    }

    const loadEpochs = async () => {
        const response = await axios.get('http://localhost:8082/epoch/getAll');
        if (response.data) {
            setEpochs(response.data.map((epoch: any) => { return { id: epoch.id, value: epoch.epochName } }));
        }
        else {
            console.log('Error loading epochs');
        }
    }

    const loadAuthors = async () => {
        const response = await axios.get('http://localhost:8082/author/getAll');
        if (response.data) {
            setAuthors(response.data.map((author: any) => { return { id: author.id, value: author.nameAuthor } }));
        }
        else {
            console.log('Error loading authors');
        }
    }

    const loadAllArtPieces = async () => {
        const response = await axios.get('http://localhost:8082/artPiece/getAll');
        if (response.data) {
            setArtPieces(response.data);
        }
        else {
            console.log('Error loading art pieces');
        }
    }

    const handleChangeYear = async (value: number) => {
        setDropdownValueYear(value);
        const response = await axios.get('http://localhost:8082/artPiece/getByYear?yearCreated=' + value);
        if (response.data !== null) {
            setArtPieces(response.data);
        }
        else {
            console.log('Error loading art pieces');
        }
    }

    const handleChangeEpoch = async (value: number) => {
        setDropdownValueEpoch(value);
        const response = await axios.get('http://localhost:8082/artPiece/getByEpoch?epochId=' + value);
        if (response.data !== null) {
            setArtPieces(response.data);
        }
        else {
            console.log('Error loading art pieces');
        }
    }

    const handleChangeAuthor = async (value: number) => {
        setDropdownValueAuthor(value);
        const response = await axios.get('http://localhost:8082/artPiece/getByAuthor?authorId=' + value);
        if (response.data !== null) {
            setArtPieces(response.data);
        }
        else {
            console.log('Error loading art pieces');
        }
    }

    const addArtPiece = (id: number) => {
        return () => {
            const artPiece = artPieces.find((artPiece: any) => artPiece.id === id);
            const allreadyAdded = selectedArtPieces.find((artPiece: any) => artPiece.id === id);
            if (artPiece && !allreadyAdded) {
                setSelectedArtPieces([...selectedArtPieces, artPiece]);
            }
        }
    }

    const removeArtPiece = (id: number) => {
        return () => {
            setSelectedArtPieces(selectedArtPieces.filter((artPiece: any) => artPiece.id !== id));
        }
    }

    const handleNavigate = () => {
        return () => {
            navigate('/cr/sortby/', { state: { artPieces: selectedArtPieces, time: (hours * 60 + minutes) } });
        }
    }

    const calculateTime = () => {
        let time = 0;
        selectedArtPieces.forEach((artPiece: any) => {
            time += Number(artPiece.retentionTime as number);
        });
        setHours(Math.floor(time / 60));
        setMinutes(time % 60);
    }

    useEffect(() => {
        calculateTime();
    }, [selectedArtPieces]);

    const loadContent = () => {
        loadYearsCreated();
        loadEpochs();
        loadAuthors();
        loadAllArtPieces();
    }

    if (!isInitialized) {
        loadContent();
        setIsInitialized(true);
    }

    console.log(artPieces)
    return (
        <div className='route-create-container-outer'>
            <div className="route-create-container">
                <h1>Create Route</h1>
                <div className='create-route-dropdowns-container'>
                    <Dropdown headerText='Year Created' value={dropdownValueYear} handleChange={handleChangeYear} options={yearsCreated} />
                    <Dropdown headerText='Epoch' value={dropdownValueEpoch} handleChange={handleChangeEpoch} options={epochs} />
                    <Dropdown headerText='Author' value={dropdownValueAuthor} handleChange={handleChangeAuthor} options={authors} />
                    <div className='create-route-dropdowns-button'>
                        <Button label='Show all' size='medium' isEnabeld={true} onClick={() => { loadAllArtPieces() }} />
                    </div>
                </div>
                <div className='create-route-art-pieces-container'>
                    <table className='create-route-art-piece'>
                        <thead>
                            <tr>
                                <th>Image</th>
                                <th>Name</th>
                                <th>Add</th>
                                <th>Remove</th>
                            </tr>
                        </thead>
                        <tbody>
                            {artPieces.length === 0 ? <tr><td colSpan={4}>No art pieces found</td></tr> :
                                artPieces.map((artPiece: any) => {
                                    return (
                                        <tr>
                                            <td>
                                                <img className='create-route-art-piece-image' src={artPiecePlaceholder} alt={artPiece.name} />
                                            </td>
                                            <td className='create-route-art-piece-name'>
                                                <h2>{artPiece.name}</h2>
                                            </td>
                                            <td className='create-route-art-piece-add'>
                                                <Button label='Add' size='medium' isEnabeld={true} onClick={addArtPiece(artPiece.id)} />
                                            </td>
                                            <td className='create-route-art-piece-remove'>
                                                <Button label='Remove' size='medium' isEnabeld={true} onClick={removeArtPiece(artPiece.id)} />
                                            </td>
                                        </tr>
                                    );
                                })}
                        </tbody>
                    </table>
                </div>
                <div className='create-route-search-by-footer'>
                    <div className='create-route-search-by-time'>
                        Approximate time to visit: {hours}h {minutes}min
                    </div>
                    <Button label='Create Route' size='large' isEnabeld={selectedArtPieces.length > 0} onClick={handleNavigate()} />
                </div>
            </div>
        </div>
    );
}