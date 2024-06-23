/* eslint-disable @typescript-eslint/no-unused-vars */
/* eslint-disable eqeqeq */
/* eslint-disable react-hooks/exhaustive-deps */
import { useContext, useState } from "react";
import "./styles/savedRoutes.css"
import { Context } from "../context";
import { RadioButtons } from "../components/radioButtonComponent/RadioButtons";
import axios from "axios";
import { Button } from "../components/buttonComponent/Button";
import { useNavigate } from "react-router-dom";

export const SavedRoutesPage = () => {
    const navigate = useNavigate();
    const { userType, userId } = useContext(Context) as any;
    const [radioValue, setRadioValue] = useState("");
    const [routes, setRoutes] = useState([]);


    const handlesetRadio = (value: string) => {
        setRadioValue(value);
        if (value === "Global routes") {
            loadAllRoutes();
        }
        if (value === "Personal routes") {
            loadPersonalRoutes();
        }
    }
    const loadAllRoutes = async () => {
        await axios.get('http://localhost:8082/route/getGlobalRoutes').then(async (response) => {
            if (response.data) {
                let tempRoutes = await addArtPiecesToRoutes(response.data.slice());
                console.log(tempRoutes[0].artPieces);
                setRoutes(tempRoutes);
            }
        }).catch((error) => {
            console.log(error);
        })
    }

    const addArtPiecesToRoutes = async (routes: any) => {
        for (let i = 0; i < routes.length; i++) {
            await axios.get(`http://localhost:8082/artPiece/getArtpiecesForRoute?routeId=${routes[i].id}`)
                .then((response) => {
                    if (response.data) {
                        routes[i].artPieces = response.data;
                    }
                });
        }
        return routes;
    }

    const loadPersonalRoutes = async () => {
        await axios.get(`http://localhost:8082/route/getRoutesForUser?userId=${userId}`).then(async (response) => {
            if (response.data) {
                let tempRoutes = await addArtPiecesToRoutes(response.data.slice());
                console.log(tempRoutes[0].artPieces);
                setRoutes(tempRoutes);
            }
        }).catch((error) => {
            console.log(error);
        })
    }

    const createAPString = (artPieces: any) => {
        let apString = "";
        for (let i = 0; i < artPieces.length; i++) {
            apString += artPieces[i].name;
            if (i < artPieces.length - 1) {
                apString += "==> ";
            }
        }
        return apString;
    }

    const handleNavigate = (artPieces: any, time: number) => {
        return () => {
            const temp = artPieces.slice();
            for (let i = 0; i < temp.length; i++) {
                temp[i].hasMovement = false;
                temp[i].hasAuthor = false;
                temp[i].hasEvent = false;
            }

            navigate('/cr/choosecontext/', { state: { artPieces: temp, time: time } });
        }
    }

    if (userType === "") {
        loadAllRoutes();
    }

    if (userType === 'admin' || userType === 'tourist') {
        return (
            <div className="saved-routes-container-outer">
                <div className="saved-routes-container">
                    <h1>Saved Routes</h1>
                    <RadioButtons labels={["Global routes", "Personal routes"]} name="routeScope" setValue={handlesetRadio} />
                    <div className="route">
                        <h2>Route Name</h2>
                        <h2>Route Duration</h2>
                        <h2>Route Desctription</h2>
                        <h3>Artpieces In Route</h3>
                        <h3>Use Route</h3>
                    </div>
                    <div className="saved-routes-box">
                        {routes.map((route: any) => {
                            return (
                                <div className="route">
                                    <h2>{route.routeName}</h2>
                                    <h2>{route.routeDuration} min</h2>
                                    <h2>{route.routeDescription}</h2>
                                    <h3>{createAPString(route.artPieces)}</h3>
                                    <Button label="Choose contex" isEnabeld={true} size="medium" onClick={handleNavigate(route.artPieces, route.routeDuration)} />
                                </div>
                            );
                        })}
                    </div>
                </div>
            </div>
        );
    } else {
        return (
            <div className="saved-routes-container-outer">
                <div className="saved-routes-container">
                    <h1>Saved Routes</h1>
                    <div className="route">
                        <h2>Route Name</h2>
                        <h2>Route Duration</h2>
                        <h2>Route Desctription</h2>
                        <h3>Artpieces In Route</h3>
                        <h2>Use Route</h2>
                    </div>
                    <div className="saved-routes-box">
                        {routes.map((route: any) => {
                            return (
                                <div className="route">
                                    <h2>{route.routeName}</h2>
                                    <h2>{route.routeDuration} min</h2>
                                    <h2>{route.routeDescription}</h2>
                                    <h3>{createAPString(route.artPieces)}</h3>
                                    <Button label="Choose contex" isEnabeld={true} size="medium" onClick={handleNavigate(route.artPieces, route.routeDuration)} />
                                </div>
                            );
                        })}
                    </div>
                </div>
            </div>
        );
    }
}