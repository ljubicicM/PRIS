import { useLocation, useNavigate } from "react-router-dom";
import arrowDown from "../assets/images/arrowDown.svg";
import './styles/routePages.css';
import { Button } from "../components/buttonComponent/Button";
import { useState } from "react";


export const CRSortByPage = () => {
    const navigate = useNavigate();
    const state = useLocation();
    const [artPieces, setArtPieces] = useState(state.state.artPieces);


    const handleNavigate = () => {
        return () => {
            const temp = artPieces.slice();
            for (let i = 0; i < temp.length; i++) {
                temp[i].hasMovement = false;
                temp[i].hasAuthor = false;
                temp[i].hasEvent = false;
            }
            console.log(temp);
            navigate('/cr/sortby/', { state: { artPieces: temp } });
        }
    }

    function compareByAM(a: any, b: any) {
        return a.artisticMovement.id - b.artisticMovement.id;
    }

    const sortByAM = () => {
        return () => {
            const temp = artPieces.slice();
            temp.sort(compareByAM);
            setArtPieces(temp);
        }
    }

    const compareByTime = (a: any, b: any) => {
        return a.yearCreated - b.yearCreated;
    }

    const sortByTime = () => {
        return () => {
            const temp = artPieces.slice();
            temp.sort(compareByTime);
            setArtPieces(temp);
        }
    }

    const permutator = (inputArr: any) => {
        let result: any = [];

        const permute = (arr: any, m = []) => {
            if (arr.length === 0) {
                result.push(m)
            } else {
                for (let i = 0; i < arr.length; i++) {
                    let curr = arr.slice();
                    let next = curr.splice(i, 1);
                    permute(curr.slice(), m.concat(next))
                }
            }
        }

        permute(inputArr)

        return result;
    }

    function calcCrow(lat1: number, lon1: number, lat2: number, lon2: number) {
        var R = 6371; // m
        var dLat = toRad(lat2 - lat1);
        var dLon = toRad(lon2 - lon1);
        lat1 = toRad(lat1);
        lat2 = toRad(lat2);

        var a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
            Math.sin(dLon / 2) * Math.sin(dLon / 2) * Math.cos(lat1) * Math.cos(lat2);
        var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        var d = R * c;
        return d;
    }

    function toRad(Value: number) {
        return Value * Math.PI / 180;
    }


    const calculateTotalDistance = (aps: any) => {
        let totalDistance = 0;
        for (let i = 0; i < aps.length - 1; i++) {
            totalDistance += calcCrow(aps[i].xCoordinate, aps[i].yCoordinate, aps[i + 1].xCoordinate, aps[i + 1].yCoordinate);
        }
        return totalDistance;
    }


    const findShortestPath = (allPermutations: any) => {
        let shortestPath = allPermutations[0];
        let shortestDistance = calculateTotalDistance(allPermutations[0]);
        for (let i = 1; i < allPermutations.length; i++) {
            let currentDistance = calculateTotalDistance(allPermutations[i]);
            if (currentDistance < shortestDistance) {
                shortestDistance = currentDistance;
                shortestPath = allPermutations[i];
            }
        }
        return shortestPath;
    }


    const sortByLWalk = () => {
        return () => {
            setArtPieces(findShortestPath(permutator(artPieces)));
        }
    }



    return (
        <div className='route-create-container-outer'>
            <div className="route-create-container">
                <div className="create-route-sort-container">
                    <div className="create-route-sort-items-list">
                        {artPieces.map((artPiece: any) => {
                            return (

                                <div className="create-route-sort-item">
                                    <img className="create-route-sort-item-img" src={arrowDown} alt="arrowDown" />
                                    <div className="create-route-sort-item-data">
                                        {artPiece.name}
                                    </div>
                                </div>
                            );
                        })}
                    </div>
                    <div className="create-route-sort-footer">
                        Sort by:
                        <div className="create-route-sort-footer-sort-btns">
                            <Button label="Artistic movement" size="medium" isEnabeld={true} onClick={sortByAM()} />
                            <Button label="Chronological" size="medium" isEnabeld={true} onClick={sortByTime()} />
                            <Button label="Least walking" size="medium" isEnabeld={true} onClick={sortByLWalk()} />
                        </div>
                        <Button label="Save" size="medium" isEnabeld={true} onClick={handleNavigate()} />
                    </div>
                </div>
            </div>
        </div>
    );
}