import { ShelfService } from '../services/ShelfService'
import type { NextPage } from 'next'
import type { EstanteType } from '../services/types'
import { Grid, GridItem } from '@chakra-ui/react'
import { Header } from '../components/Header'
import { NicheArea } from '../components/Niche/NicheArea'
import { Shelf } from '../components/Shelf'
import { ResumeShelf } from '../components/Shelf/ResumeShelf'
import { useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { fetchEstanteRequest, fetchEstanteSuccess, setCurrentEstante } from '../store/estante/actions'
import { AppState } from '../store'

interface IHome {
  estantes ?: EstanteType[]
}

const Home: NextPage = ({ estantes }: IHome) => {
  const { estantes: estantesState } = useSelector(({ estante }: AppState) => estante)
  const dispatch = useDispatch()
  useEffect(() => {
    dispatch(fetchEstanteRequest())
    if (estantes) {
      dispatch(fetchEstanteSuccess({ estantes }))
      dispatch(setCurrentEstante({ estante: estantes[0] }))
    }
  }, [estantes])
  return (
    <Grid
      templateAreas={`
        "header header"
        "main nav1"
        "main nav2"
        "main nav2"
      `}
      templateRows="2fr 6fr 2fr 3fr"
      templateColumns="9fr 3fr"
      gap="0.5rem"
      padding="2rem"
      height="100%"
    >
      <GridItem area="header" height="fit-content">
        <Header />
      </GridItem>
      <GridItem area="main" alignItems="center">
        <NicheArea />
      </GridItem>

      <Shelf estantes={estantesState} />
      <ResumeShelf />
    </Grid>
  )
}

export default Home

Home.getInitialProps = async (context) => {
  const estantes = await ShelfService.getAllShelfs()
  return { estantes }
}
