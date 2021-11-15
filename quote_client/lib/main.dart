import 'package:flutter/material.dart';
import 'package:qute_quote_client/quote_pages/IP_screen.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "FLutter demo",
      theme: ThemeData.dark(),
      home: IP_screen(),
      debugShowCheckedModeBanner: false,
    );
  }
}
