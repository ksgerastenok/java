package event.gzip;

import java.nio.file.*;
import java.nio.channels.*;
import java.util.*;

public class GZip extends Object {
    private Worker worker;
    private Producer producer;
    private Consumer consumer;
    private Exception except;
    private List<Thread> thread;

    public GZip(Worker worker, Consumer consumer, Producer producer) {
        this.except = new Exception();
        this.thread = new ArrayList<>();
        this.worker = worker;
        this.consumer = consumer;
        this.producer = producer;
        for (int i = 0; i != 10; i += 1) {
            this.thread.add(null);
        }

        return;
    }

    public void process(String input, String output) throws Exception {
        try (FileChannel reader = FileChannel.open(Paths.get(input), StandardOpenOption.READ)) {
            try (FileChannel writer = FileChannel.open(Paths.get(output), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING)) {
                this.start(reader, writer);
            }
        }

        return;
    }

    private void start(FileChannel reader, FileChannel writer) throws Exception {
        for (int i = 0; i != this.thread.size(); i += 1) {
            this.thread.set(i, new Thread(() -> this.safe(reader, writer)));
        }
        for (int i = 0; i != this.thread.size(); i += 1) {
            this.thread.get(i).setName(String.format("Thread-%s-%d", this.getClass().getSimpleName(), i + 1));
            this.thread.get(i).start();
        }
        for (int i = 0; i != this.thread.size(); i += 1) {
            this.thread.get(i).join();
        }
        if (!(this.except.getSuppressed().length == 0)) {
            throw (this.except);
        }

        return;
    }

    private void stop() {
        for (int i = 0; i != this.thread.size(); i += 1) {
            this.thread.get(i).interrupt();
        }

        return;
    }

    private void safe(FileChannel reader, FileChannel writer) {
        Data data = new Data();

        try {
            if (!(this.worker == null)) {
                if (!(this.producer == null)) {
                    if (!(this.consumer == null)) {
                        while (!(Utils.ChannelAvailable(reader) == 0)) {
                            synchronized (reader) {
                                if (!(Utils.ChannelAvailable(reader) == 0)) {
                                    this.consumer.process(reader, data);
                                }
                            }

                            if (!((data.getData() == null) && (data.getPosition() == 0))) {
                                this.worker.process(data);
                            }

                            synchronized (writer) {
                                if (!((data.getData() == null) && (data.getPosition() == 0))) {
                                    this.producer.process(writer, data);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(String.format("THREAD %s, Except.Class: %s, Except.Msg: %s", Thread.currentThread().getName(), ex.getClass().getSimpleName(), ex.getMessage()));
            this.except.addSuppressed(ex);
            this.stop();
        }
    }
}
