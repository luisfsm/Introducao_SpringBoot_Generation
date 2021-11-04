import React, { useState } from 'react'
import { AppBar, Tab, Tabs, Typography, Box } from '@material-ui/core';
import { TabContext, TabPanel } from '@mui/lab';
import ListaPostagem from '../listapostagem/ListaPostagem';
import './TabPostagem.css';



function TabPostagem() {
    const [value, setValue] = useState('1')
    function handleChange(event: React.ChangeEvent<{}>, newValue: string) {
        setValue(newValue);
    }

    return (
        <>
            <TabContext value={value}>
                <AppBar position="static">
                    <Tabs centered indicatorColor="secondary" onChange={handleChange}>
                        <Tab label="Todas as postagens" value="1" />
                        <Tab label="Sobre-nós" value="2" />
                    </Tabs>
                </AppBar>
                <TabPanel value="1" >
                    <Box display="flex" flexWrap="wrap" justifyContent="center">
                        <ListaPostagem />
                    </Box>
                </TabPanel>
                <TabPanel value="2">
                    <Typography variant="h5" gutterBottom color="textPrimary" component="h5" align="center" className="titulo"></Typography>
                    <Typography variant="body1" gutterBottom color="textPrimary" align="justify">Lorem ipsum dolor sit amet consectetur adipisicing elit. Totam odio nemo delectus assumenda vero deserunt incidunt soluta quo nihil sit, magnam quidem modi, ullam dolor nulla. Quod placeat delectus ipsum!</Typography>
                </TabPanel>
            </TabContext>
        </>
    );
}
export default TabPostagem;
