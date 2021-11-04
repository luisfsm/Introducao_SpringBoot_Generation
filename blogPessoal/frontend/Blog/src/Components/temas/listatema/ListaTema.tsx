import React, { useState, useEffect } from 'react'
import { Link, useHistory } from 'react-router-dom'
import { Box, Card, CardActions, CardContent, Button, Typography } from '@material-ui/core'
import Temas from '../../../Models/Temas';
import './ListaTema.css';
import useLocalStorage from 'react-use-localstorage';
import { busca } from './../../../Services/Service';
function ListaTema() {

    const [Temas, setTemas] = useState<Temas[]>([]);
    const [token, setToken] = useLocalStorage('token')
    let history = useHistory();

    useEffect(() => {
        if (token == "") {
            alert("você precisa estar logado")
           history.push("/login")
        }
    }, [token])

    async function getTema(){
        await busca("/temas", setTemas, {
          headers: {
            'Authorization': token
          }
        })
      }

    useEffect(() => {
        getTema()
    }, [Temas.length])
    return (
        <>
            {
                Temas.map(tema=>(

                <Box m={2} >
                    <Card variant="outlined">
                        <CardContent>
                            <Typography color="textSecondary" gutterBottom>
                                Tema
                            </Typography>
                            <Typography variant="h5" component="h2">
                               {tema.descricao}
                            </Typography>
                        </CardContent>
                        <CardActions>
                            <Box display="flex" justifyContent="center" mb={1.5} >
                                <Link to={`/formularioTema/${tema.id}`} className="text-decorator-none">
                                    <Box mx={1}>
                                        <Button variant="contained" className="marginLeft" size='small' color="primary">
                                            atualizar
                                        </Button>
                                    </Box>
                                </Link>
                                <Link to={`/deletarTema/${tema.id}`} className="text-decorator-none">
                                    <Box mx={1}>
                                        <Button variant="contained" size='small' color="secondary">
                                            deletar
                                        </Button>
                                    </Box>
                                </Link>
                            </Box>
                        </CardActions>
                    </Card>
                </Box>
            ))}
        </>
    );
}
export default ListaTema;