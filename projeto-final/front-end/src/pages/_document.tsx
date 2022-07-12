import Document, { DocumentContext, Head, Html, Main, NextScript } from 'next/document'
import { ColorModeScript, theme } from '@chakra-ui/react'

class MyDocument extends Document {
  static async getInitialProps (ctx: DocumentContext) {
    const originalRenderPage = ctx.renderPage
    ctx.renderPage = () =>
      originalRenderPage({
        enhanceApp: (App) => App,
        enhanceComponent: (Component) => Component
      })
    const initialProps = await Document.getInitialProps(ctx)

    return initialProps
  }

  render () {
    return (
      <Html>
       <Head />
        <body>
          <ColorModeScript initialColorMode={theme.config.initialColorMode} />
          <Main />
          <NextScript />
        </body>
      </Html>
    )
  }
}

export default MyDocument
